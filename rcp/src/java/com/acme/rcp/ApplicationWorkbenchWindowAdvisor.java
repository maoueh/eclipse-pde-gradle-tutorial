package com.acme.rcp;

import org.eclipse.swt.graphics.*;
import org.eclipse.ui.application.*;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    @Override
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    @Override
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(900, 750));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(true);
        configurer.setTitle("Acme RCP"); //$NON-NLS-1$
    }
}
