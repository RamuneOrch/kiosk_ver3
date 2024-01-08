package sparta.java_project.kiosk_ver3.controller;
import sparta.java_project.kiosk_ver3.service.KioskService;
import sparta.java_project.kiosk_ver3.view.Input;

public class Application_Kiosk {

    private final KioskService kioskService = new KioskService();

    public void start() {
        // 1. 데이터초기화
        kioskService.initCafeData();
        // 2. 초기화된 데이터를 기준으로 print
        kioskService.showInfo();
    }
}
