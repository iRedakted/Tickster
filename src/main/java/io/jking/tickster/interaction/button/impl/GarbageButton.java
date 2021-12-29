package io.jking.tickster.interaction.button.impl;

import io.jking.tickster.interaction.button.AbstractButton;
import io.jking.tickster.interaction.core.impl.ButtonSender;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class GarbageButton extends AbstractButton {
    public GarbageButton() {
        super("button:garbage:id:%s");
    }

    @Override
    public void onButtonPress(ButtonSender context) {
        context.deferReply().flatMap(InteractionHook::deleteOriginal).queue();
    }
}
