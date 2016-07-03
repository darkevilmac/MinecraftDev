package com.demonwav.mcdev.platform.bukkit;

import com.demonwav.mcdev.asset.PlatformAssets;
import com.demonwav.mcdev.platform.AbstractModuleType;
import com.demonwav.mcdev.platform.PlatformType;

import com.google.common.collect.ImmutableList;
import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.swing.Icon;

public class BukkitModuleType extends AbstractModuleType<BukkitModule<?>> {

    private static final String ID = "BUKKIT_MODULE_TYPE";
    private static final BukkitModuleType instance = new BukkitModuleType();

    private BukkitModuleType() {
        super("org.bukkit", "bukkit");
    }

    protected BukkitModuleType(final String ID, final String groupId, final String artifactId) {
        super(groupId, artifactId);
    }

    public static BukkitModuleType getInstance() {
        return instance;
    }

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.BUKKIT;
    }

    @Override
    public Icon getBigIcon() {
        return PlatformAssets.BUKKIT_ICON_2X;
    }

    @Override
    public Icon getIcon() {
        return PlatformAssets.BUKKIT_ICON;
    }

    public String getId() {
        return ID;
    }

    @NotNull
    @Override
    public List<String> getIgnoredAnnotations() {
        return ImmutableList.of("org.bukkit.event.EventHandler");
    }

    @NotNull
    @Override
    public List<String> getListenerAnnotations() {
        return ImmutableList.of("org.bukkit.event.EventHandler");
    }

    @NotNull
    @Override
    public BukkitModule generateModule(Module module) {
        return new BukkitModule<>(module, this);
    }
}
