package app.encryption;

import app.utils.IWorker;

public abstract class Encryption implements IWorker {
    @Override
    public void doWork() {
        System.out.printf("Результат шифрования: %s\n\n", encrypt());
    }

    abstract String encrypt();
}