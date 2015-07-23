package com.acme.rcp;

import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.ui.application.*;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    @Override
    protected void makeActions(IWorkbenchWindow window) {}

    @Override
    protected void fillMenuBar(IMenuManager menuBar) {}

}
