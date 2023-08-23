package com.vaadin.training.clientside.cssinject;

import com.vaadin.server.AbstractExtension;
import com.vaadin.training.clientside.cssinject.client.CssInjectState;
import com.vaadin.ui.AbstractComponent;

public class CssInject extends AbstractExtension {

    @Override
    public CssInjectState getState() {
        return (CssInjectState) super.getState();
    }

    public void extend(AbstractComponent target) {
        super.extend(target);
    }

    public void addStyle(String property, String value) {
        // TODO: store style to shared state
    }

    public void removeStyle(String property) {
        // TODO: remove style from shared state
    }
}
