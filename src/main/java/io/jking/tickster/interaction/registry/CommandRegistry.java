package io.jking.tickster.interaction.registry;

import io.jking.tickster.interaction.Registry;
import io.jking.tickster.interaction.impl.slash.core.Category;
import io.jking.tickster.interaction.impl.slash.core.Command;
import net.dv8tion.jda.api.entities.Member;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CommandRegistry extends Registry<Command> {

    public List<Command> getCommands() {
        return this.getMap().values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Category> getCategories(Member member) {
        return this.getMap().values()
                .parallelStream()
                .map(Command::getCategory)
                .filter(category -> category.isPermitted(member))
                .distinct()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Command> getCommandsByCategory(Category category, Member member) {
        return this.getMap()
                .values()
                .parallelStream()
                .filter(command -> member.hasPermission(command.getPermission()))
                .filter(command -> command.getCategory() == category)
                .sorted(Comparator.comparing(Command::getName))
                .distinct()
                .collect(Collectors.toUnmodifiableList());
    }

}
