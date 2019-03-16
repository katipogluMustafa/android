# Delay

## by using android.os.Handler

* Delay for given milliseconds

```java
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AppConnectActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }, 3000);
```
