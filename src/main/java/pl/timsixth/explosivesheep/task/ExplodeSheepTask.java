package pl.timsixth.explosivesheep.task;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.scheduler.BukkitRunnable;

public class ExplodeSheepTask extends BukkitRunnable {

    private final Sheep sheep;

    public ExplodeSheepTask(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    public void run() {
        sheep.remove();
        sheep.getLocation().getWorld().spawnEntity(sheep.getLocation(), EntityType.PRIMED_TNT);
    }
}
