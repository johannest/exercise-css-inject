package com.vaadin.training.clientside.cssinject.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.training.clientside.cssinject.CssInject;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("CssInject Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "com.vaadin.training.clientside.cssinject.demo.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final Label label = new Label("Change my style");
        final CssInject inject = new CssInject();
        inject.extend(label);

        layout.addComponent(label);

        Button button = new Button("Background: red");
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                inject.addStyle("background-color", "red");
            }
        });
        layout.addComponent(button);
        layout.addComponent(
                new Button("Background: green", new ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        inject.addStyle("background-color", "#00ff00");
                    }
                }));
        layout.addComponent(new Button("Border: black", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                inject.addStyle("border", "solid 1px #000000");
            }
        }));
        layout.addComponent(new Button("Remove border", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                inject.removeStyle("border");
            }
        }));

        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        final TextField property = new TextField("CSS property");
        hl.addComponent(property);

        final TextField propertyValue = new TextField("Value");
        hl.addComponent(propertyValue);

        Button setButton = new Button("Set", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                inject.addStyle(property.getValue(), propertyValue.getValue());
            }
        });
        hl.addComponent(setButton);

        hl.setComponentAlignment(setButton, Alignment.BOTTOM_RIGHT);
        layout.addComponent(hl);
    }

}
