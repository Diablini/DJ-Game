package com.djgame.ChooseHandling;

abstract class ChooseRequest {
    public ChooseListener.ChooseRequestType type;
    public InfoCarrier info;
    public abstract void callback();
}
