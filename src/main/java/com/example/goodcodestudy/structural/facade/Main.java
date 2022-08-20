package com.example.goodcodestudy.structural.facade;

public class Main {
    public static void main(String[] args) {

        // 여기서 computer가 facade 역할을 한다.
        // 클라이언트에게 단순한 메서드를 제공해주고 뒷쪽에 있는 상호작용들을 숨기는 것을 facade 패턴이다.
        Computer computer = new Computer();
        computer.turnOn();

//        Power power = new Power();
//
//        if (!power.checkElectric()) {
//            System.out.println("전력이 비정상");
//            System.out.println("전력이 비정상");
//            return;
//        }
//
//        Mainboard mainboard = new Mainboard();
//        ReadOnlyMemory rom = mainboard.supply(power);
//        Bios bios = rom.getBios();
//
//        if (!bios.post()) {
//            System.out.println("장치가 불량임");
//            return;
//        }
//
//        BootLoader bootLoader = bios.getBootLoader(rom);
//        HardDiskDrive hdd = new HardDiskDrive();
//        OperationSystem os = bootLoader.findOperationSystem(hdd);
//        RandomAccessMomory ram = new RandomAccessMomory();
//        os.bootStrap(ram);
    }
}
