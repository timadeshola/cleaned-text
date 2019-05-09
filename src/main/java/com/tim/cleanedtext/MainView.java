package com.tim.cleanedtext;

import com.tim.cleanedtext.utils.AppUtils;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;


/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "Clean Text Application", shortName = "Clean Text Application")
public class MainView extends VerticalLayout {

    TextField originalText = new TextField("Original Text", textFieldStringComponentValueChangeEvent -> set());
    Label cleanedText = new Label("Cleaned Text");

//    Button cleanButton = new Button("Clean Text");

    public MainView() {

//        cleanButton.addClickListener(event -> set());

        add(originalText);
        add(cleanedText);
//        add(cleanButton);
    }

    public void set() {
        String sanitizeText = AppUtils.sanitizeText(originalText.getValue());
        cleanedText.setText(sanitizeText);
        Notification.show(cleanedText.getText()).setPosition(Notification.Position.TOP_END);
    }
}
