package com.gxg;


import com.gxg.CommUtils.CaseLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        CaseLoader caseLoader = new CaseLoader();
        caseLoader.load().run();
    }
}
