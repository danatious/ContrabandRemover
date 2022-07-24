package tk.danatious;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.Iterator;

public class Purger extends BukkitRunnable {
    public Purger() {
        this.runTaskTimer(ContrabandRemover.getPlugin(ContrabandRemover.class),0,1);
    }

    @Override
    public void run() {
        Collection<? extends Player> players = ContrabandRemover.getPlugin(ContrabandRemover.class).getServer().getOnlinePlayers();
        Iterator<Player> playerIterator = (Iterator<Player>) players.iterator();

        while (playerIterator.hasNext()) {
            playerIterator.next().getInventory().removeItem(BlacklistManager.getBlacklistArray());
        }
    }
}
