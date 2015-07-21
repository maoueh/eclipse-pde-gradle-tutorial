package com.acme.plugin;

import org.eclipse.jface.resource.*;
import org.eclipse.ui.plugin.*;
import org.osgi.framework.*;

public class Activator extends AbstractUIPlugin {

    public static final String PLUGIN_ID = "com.acme.plugin"; //$NON-NLS-1$

    private static Activator sPlugin;

    public Activator() {}

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        sPlugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        sPlugin = null;
        super.stop(context);
    }

    public static Activator getDefault() {
        return sPlugin;
    }

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
}
