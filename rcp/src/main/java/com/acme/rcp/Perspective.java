package com.acme.rcp;

import org.eclipse.ui.*;

import com.acme.plugin.views.*;

public class Perspective implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
        layout.addView(ShowcaseView.ID, IPageLayout.TOP, 0.90f, IPageLayout.ID_EDITOR_AREA);
    }

}
