package com.vaadin.training.clientside.cssinject.client;

import com.google.gwt.user.client.Element;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.training.clientside.cssinject.CssInject;

@Connect(CssInject.class)
public class CssInjectConnector extends AbstractExtensionConnector {

    private static final long serialVersionUID = 1L;

    private Element element;

    @Override
    public CssInjectState getState() {
        return (CssInjectState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        // TODO: Update styles based on the shared state
    }

    @Override
    protected void extend(ServerConnector target) {
        element = ((ComponentConnector) target).getWidget().getElement();
    }

}
