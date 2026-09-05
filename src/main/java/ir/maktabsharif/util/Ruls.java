package ir.maktabsharif.util;

import ir.maktabsharif.exception.Validation;

public class Ruls {

    private Ruls(){

    }

    public static void Check (
            Boolean validation,
            String message
    )throws Validation{
        if (validation) throw new Validation(message);
    }
}
