package com.cleverdev.cleverdev.testtask.utils;

import com.cleverdev.cleverdev.testtask.service.ImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class ImportScheduler {

    private final ImportService importService;
    @Scheduled(cron = "0 15 */2 * * *")
    public void scheduleImport() {
        importService.importData();
        log.info("Scheduled method executed");
    }
}
