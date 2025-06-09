package com.varun.appInstallation.Repository;

import com.varun.appInstallation.Entity.AppToInstall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppToInstallRepository extends JpaRepository<AppToInstall, Long> {
    List<AppToInstall> findByAssignedIp(String assignedIp);
}
