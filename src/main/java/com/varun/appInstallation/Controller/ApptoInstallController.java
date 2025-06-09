package com.varun.appInstallation.Controller;

import com.varun.appInstallation.Entity.AppToInstall;
import com.varun.appInstallation.Repository.AppToInstallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/apps")
public class ApptoInstallController {

    @Autowired
    private AppToInstallRepository appRepo;

    @GetMapping("/install")
    public ResponseEntity<String> installApk(@RequestParam String ip) {
        List<AppToInstall> apps = appRepo.findByAssignedIp(ip);

        for (AppToInstall app : apps) {
            try {
                // 1. Connect to device
                new ProcessBuilder("adb", "connect", ip).start().waitFor();

                // 2. Install APK
                new ProcessBuilder("adb", "install", app.getApkPath()).start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body("Error installing app: " + app.getAppName());
            }
        }

        return ResponseEntity.ok("Apps installed successfully on " + ip);
    }

}

