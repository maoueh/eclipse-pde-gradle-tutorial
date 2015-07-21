package com.acme.rcp;

import org.eclipse.equinox.app.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;

public class Application implements IApplication {

    @Override
    public Object start(IApplicationContext context) throws Exception {
        Display display = PlatformUI.createDisplay();
        try {
            int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
            if (returnCode == PlatformUI.RETURN_RESTART) return IApplication.EXIT_RESTART;
            else return IApplication.EXIT_OK;
        } finally {
            display.dispose();
        }

    }

    @Override
    public void stop() {
        if (!PlatformUI.isWorkbenchRunning()) return;

        final IWorkbench workbench = PlatformUI.getWorkbench();
        final Display display = workbench.getDisplay();
        display.syncExec(new Runnable() {
            @Override
            public void run() {
                if (!display.isDisposed()) {
                    workbench.close();
                }
            }
        });
    }
}
