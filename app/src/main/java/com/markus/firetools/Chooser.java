package com.markus.firetools;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepFragment;
import android.support.v17.leanback.widget.GuidanceStylist;
import android.support.v17.leanback.widget.GuidedAction;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
public class Chooser extends GuidedStepFragment {
    private final int ACTION_TWRP = 1;
    private final int ACTION_SLEEP = 2;
    private final int ACTION_DEVICE = 3;
    private final int ACTION_DISPLAYSOUNDS = 4;
    private final int ACTION_NETWORK = 5;
    private final int ACTION_DEVICES = 6;
    private final int ACTION_ACCESSIBILITY = 7;
    private final int ACTION_APPS = 8;
    private final int ACTION_PREFERENCES = 9;
    private final int ACTION_EQUIPMENT = 10;
    private final int ACTION_NOTIFICATIONS = 11;
    private final int ACTION_ACCOUNT = 12;
    private final int ACTION_ADB = 13;
    private final int ACTION_INSECAPP = 14;

    private static void addAction(List<GuidedAction> actions, long id, String title, String desc){
        actions.add(new GuidedAction.Builder()
                .id(id)
                .title(title)
                .description(desc)
                .build());
    }

    @NonNull
    @Override
    public GuidanceStylist.Guidance onCreateGuidance(Bundle savedInstanceState) {
        String title = getString(R.string.app_name);
        String breadcrumb = getString(R.string.two_opts_nix);
        String description = getString(R.string.two_opts_nix);
        Drawable icon = getActivity().getDrawable(R.drawable.ic_logo);
        return new GuidanceStylist.Guidance(title, description, breadcrumb, icon);

    }

    @Override
    public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
        super.onCreateButtonActions(actions,savedInstanceState);
        addAction(actions,ACTION_TWRP,getString(R.string.two_opts_res5)," ");
        addAction(actions,ACTION_SLEEP,getString(R.string.two_opts_res3)," ");
        addAction(actions,ACTION_DEVICE,getString(R.string.two_opts_device)," ");
        addAction(actions,ACTION_DISPLAYSOUNDS,getString(R.string.two_opts_display)," ");
        addAction(actions,ACTION_NETWORK,getString(R.string.two_opts_net)," ");
        addAction(actions,ACTION_DEVICES,getString(R.string.two_opts_dev)," ");
        addAction(actions,ACTION_ACCESSIBILITY,getString(R.string.two_opts_access)," ");
        addAction(actions,ACTION_APPS,getString(R.string.two_opts_app)," ");
        addAction(actions,ACTION_PREFERENCES,getString(R.string.two_opts_pref)," ");
        addAction(actions,ACTION_EQUIPMENT,getString(R.string.two_opts_res2)," ");
        addAction(actions,ACTION_NOTIFICATIONS,getString(R.string.two_opts_res1)," ");
        addAction(actions,ACTION_ACCOUNT,getString(R.string.two_opts_account)," ");
        addAction(actions,ACTION_ADB,getString(R.string.two_opts_res6)," ");
        addAction(actions,ACTION_INSECAPP,getString(R.string.two_opts_res7)," ");
    }

    @Override
    public void onGuidedActionClicked(GuidedAction action) {
        super.onGuidedActionClicked(action);
        if (action.getId() == ACTION_DISPLAYSOUNDS)         {
            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.DISPLAY_AND_SOUNDS -n com.amazon.tv.settings.v2/.tv.display_sounds.DisplayAndSoundsActivity"});
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (action.getId() == ACTION_NETWORK) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.ADD_NETWORK -n com.amazon.tv.settings.v2/.tv.network.NetworkActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_DEVICES) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.CONTROLLERS -n com.amazon.tv.settings.v2/.tv.controllers_bluetooth_devices.ControllersAndBluetoothActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_ACCESSIBILITY) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.ACCESSIBILITY -n com.amazon.tv.settings.v2/.tv.accessibility.AccessibilityActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_APPS) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.APPLICATIONS -n com.amazon.tv.settings.v2/.tv.applications.ApplicationsActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_PREFERENCES) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.PREFERENCES -n com.amazon.tv.settings.v2/.tv.preferences.PreferencesActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_DEVICE) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.DEVICE -n com.amazon.tv.settings.v2/.tv.device.DeviceActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_SLEEP) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "input keyevent 223"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_EQUIPMENT) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.tv.oobe.settings.ACTION.DEVICE_CONTROL -n com.amazon.tv.devicecontrolsettings/.screens.main_menu.OzOobeSettingsActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_NOTIFICATIONS) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.tv.action.NOTIFICATION_CENTER -n com.amazon.tv.notificationcenter/.NotificationCenterActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_TWRP) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "/system/bin/svc power reboot"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_ADB) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "settings put global adb_enabled 1"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_INSECAPP) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "settings put secure install_non_market_apps 1"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (action.getId() == ACTION_ACCOUNT) {

            try {
                Runtime.getRuntime().exec(new String[]{"su", "-c", "am start -a com.amazon.device.settings.action.MY_ACCOUNT -n com.amazon.tv.settings.v2/.tv.my_account.MyAccountActivity"});
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}