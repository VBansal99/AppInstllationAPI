package com.varun.appInstallation.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "apps_to_install")
public class AppToInstall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appName;

    private String packageName;

    private String apkFilename;

    private String apkPath;

    private String assignedIp;

    private Integer versionCode;

    private Timestamp uploadedAt;

}
