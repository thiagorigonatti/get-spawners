package me.thiagorigonatti.getspawners.core;

import me.thiagorigonatti.getspawners.customconfig.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import me.thiagorigonatti.getspawners.customconfig.VersionComparator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CheckLatest implements Listener {
    public static String versionMessage;
    private static String githubVersion;
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);
    private static HttpURLConnection httpURLConnection;

    void getGSVersion() {
        try {
            StringBuilder stringBuilder = new StringBuilder();

            URL gsBlog = new URL("https://raw.githubusercontent.com/thiagorigonatti/get-spawners/main/VERSION");

            httpURLConnection = (HttpURLConnection) gsBlog.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                stringBuilder.append(inputLine);

            in.close();

            githubVersion = stringBuilder.toString().replaceAll("%", "");

            if (VersionComparator.isOutOfDate(getSpawners.getDescription().getVersion(), githubVersion)) {
                versionMessage = "§cYou don't have the latest version!§r";
            } else {
                versionMessage = "   §bYou have the latest version!§r   ";
            }
        } catch (IOException e) {
            versionMessage = " §eDon't worry, can't connect to db!§r";
        } finally {
            httpURLConnection.disconnect();
        }
    }


/*    @EventHandler
    private void onOpJoin(PlayerJoinEvent event) {
        if (event.getPlayer().isOp()) {
            if (VersionComparator.isOutOfDate(getSpawners.getDescription().getVersion(), githubVersion)) {
                event.getPlayer().sendMessage(Messages.PREFIX + " " + "§6There is a new updated version available!\n" +
                        "current version: §e§l" + getSpawners.getDescription().getVersion() + " §6new version: §a§l" + githubVersion + " §6click to download:\n§3https://github.com/thiagorigonatti/get-spawners/releases");
                event.getPlayer().sendMessage("");
            }
        }
    }*/
}
