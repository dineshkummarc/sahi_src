package net.sf.sahi.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.sahi.config.Configuration;

public class ProxySwitcher {

	private static String toolsBasePath = Configuration.getToolsPath();

    /**
     * Restores System Proxy settings to what was before.
     * Used with configureSahiAsSystemProxy()
     */
	public static void revertSystemProxy() {
		execCommand(toolsBasePath + "/proxy_config.exe original");
	}
	
	/**
	 * Sets System proxy settings to localhost 9999
	 */
	public static void setSahiAsProxy() {
		execCommand(toolsBasePath + "/backup_proxy_config.exe");
		execCommand(toolsBasePath + "/proxy_config.exe sahi_https");
	}
	
	private static void execCommand(String cmd) {
        try {
            Utils.executeCommand(Utils.getCommandTokens(cmd));
        } catch (Exception ex) {
            Logger.getLogger(ProxySwitcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
