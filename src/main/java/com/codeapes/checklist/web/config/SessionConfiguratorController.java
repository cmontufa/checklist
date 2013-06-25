package com.codeapes.checklist.web.config;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeapes.checklist.domain.search.SearchResult;
import com.codeapes.checklist.service.config.SessionConfiguratorService;
import com.codeapes.checklist.service.search.SearchService;
import com.codeapes.checklist.util.AppLogger;
import com.codeapes.checklist.web.util.WebSecurityConstants;
import com.codeapes.checklist.web.viewhelper.ViewHelperUtility;
import com.codeapes.checklist.web.viewhelper.search.SearchResultViewHelper;

@Controller
public class SessionConfiguratorController {

    private static final AppLogger logger = new AppLogger(SessionConfiguratorController.class); // NOSONAR
    
    @Autowired
    private SessionConfiguratorService sessionConfigService;

    @RequestMapping(method = RequestMethod.GET, value = "/sessionConfig")
    @PreAuthorize(WebSecurityConstants.USER_ROLE)
    public String processView(HttpServletRequest request,
            HttpServletResponse response, Model model) {

        logger.debug("Session Configurator(View) invoked.");
        final String log4JConfigText = (String)request.getParameter("log4jConfigText");
        logger.debug("Log4J Config Text: %s", log4JConfigText);
        model.addAttribute("currentLogLevel", LogManager.getRootLogger().getLevel().toString());
        //LogManager.getRootLogger().setLevel(level);

        return "sessionconfig";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/sessionConfig")
    @PreAuthorize(WebSecurityConstants.USER_ROLE)
    public String processSubmit(HttpServletRequest request,
            HttpServletResponse response, Model model) {

        logger.debug("Session Configurator(Submit) invoked.");
        final String log4JConfigText = (String)request.getParameter("log4jConfigText");
        logger.debug("Log4J Config Text: %s", log4JConfigText);
                
        //Global Set
        Enumeration<Category> allLoggingTiers = LogManager.getRootLogger().getLoggerRepository().getCurrentCategories();
        
        while (allLoggingTiers.hasMoreElements()){
        	Category tempLogger = (Category) allLoggingTiers.nextElement();
        	tempLogger.setLevel((Level) Level.toLevel(log4JConfigText)); 
        }
        //Set at Root
        LogManager.getRootLogger().setLevel((Level) Level.toLevel(log4JConfigText));
        
        model.addAttribute("newLog4JConfigText", log4JConfigText);
        return "sessionconfigresult";
    }

}
