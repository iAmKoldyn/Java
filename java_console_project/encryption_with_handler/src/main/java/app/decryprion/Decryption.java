package app.decryprion;

import app.utils.IWorker;

public abstract class Decryption implements IWorker {
    @Override
    public void doWork() {
        System.out.printf("Результат расшифровки: %s\n\n", decrypt());
    }

    abstract String decrypt();
}