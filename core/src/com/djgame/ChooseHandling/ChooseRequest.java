package com.djgame.ChooseHandling;

public abstract class ChooseRequest {
    public ChooseListener.ChooseRequestType type;
    public InfoCarrier info;
    public String prompt;
    public abstract void callback();
}
