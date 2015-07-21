package com.acme.plugin.views;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;
import org.eclipse.ui.part.*;

import com.acme.api.services.model.*;
import com.acme.framework.services.helper.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class ShowcaseView extends ViewPart {

    public static final String ID = "com.acme.plugin.views.ShowcaseView";

    private TableViewer mTableViewer;
    private Action mShowCallAction;

    public ShowcaseView() {}

    @Override
    public void createPartControl(Composite parent) {
        mTableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        mTableViewer.setContentProvider(new ViewContentProvider());
        mTableViewer.setLabelProvider(new ViewLabelProvider());
        mTableViewer.setSorter(new NameSorter());
        mTableViewer.setInput(getViewSite());

        PlatformUI.getWorkbench().getHelpSystem().setHelp(mTableViewer.getControl(), "com.acme.plugin.viewer");
        getSite().setSelectionProvider(mTableViewer);

        mShowCallAction = createShowCallAction();

        hookActionBars();
        hookContextMenu();
    }

    @Override
    public void setFocus() {
        mTableViewer.getControl().setFocus();
    }

    private void hookContextMenu() {
        MenuManager menuMgr = new MenuManager("#PopupMenu");
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                ShowcaseView.this.fillContextMenu(manager);
            }
        });

        Menu menu = menuMgr.createContextMenu(mTableViewer.getControl());
        mTableViewer.getControl().setMenu(menu);
        getSite().registerContextMenu(menuMgr, mTableViewer);
    }

    private void hookActionBars() {
        IActionBars bars = getViewSite().getActionBars();
        fillLocalPullDown(bars.getMenuManager());
        fillLocalToolBar(bars.getToolBarManager());
    }

    private Action createShowCallAction() {
        Action action = new Action() {
            @Override
            public void run() {
                showMessage(CallFormatter.formatCall(new Call(2543L)));
            }
        };

        action.setText("Show Call");
        action.setToolTipText("Display formatted call.");
        action.setImageDescriptor(PlatformUI.getWorkbench()
                                  .getSharedImages()
                                  .getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

        return action;
    }

    private void fillLocalPullDown(IMenuManager manager) {
        manager.add(mShowCallAction);
    }

    private void fillContextMenu(IMenuManager manager) {
        manager.add(mShowCallAction);
        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
    }

    private void fillLocalToolBar(IToolBarManager manager) {
        manager.add(mShowCallAction);
    }

    private void showMessage(String message) {
        MessageDialog.openInformation(mTableViewer.getControl().getShell(), "Showcase View", message);
    }

    class ViewContentProvider implements IStructuredContentProvider {
        @Override
        public void inputChanged(Viewer v, Object oldInput, Object newInput) {}

        @Override
        public void dispose() {}

        @Override
        public Object[] getElements(Object parent) {
            List<Call> calls = newArrayList(new Call(675L), new Call(25478L), new Call(9584L));

            return Lists.transform(calls, Functions.toStringFunction()).toArray();
        }
    }

    class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
        @Override
        public String getColumnText(Object obj, int index) {
            return getText(obj);
        }

        @Override
        public Image getColumnImage(Object obj, int index) {
            return getImage(obj);
        }

        @Override
        public Image getImage(Object obj) {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
        }
    }

    class NameSorter extends ViewerSorter {}

}
