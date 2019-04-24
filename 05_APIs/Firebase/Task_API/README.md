# TASK API

## Activity Leak

````java

// This code may contain activity leak if the listener called after activity destroyed
Task task = forestRef.getMetadata();
    task.addOnSuccessListener(new OnSuccessListener() {
        @Override
        public void onSuccess(StorageMetadata storageMetadata) {
            // Metadata now contains the metadata for 'images/forest.jpg'
        }
    });
````

````java
Task task = forestRef.getMetadata();
    // By giving this parameter here, your listener will be deleted when onStop called
    task.addOnSuccessListener(this, new OnSuccessListener() {
        @Override
        public void onSuccess(StorageMetadata storageMetadata) {
            // Metadata now contains the metadata for 'images/forest.jpg'
        }
    });
````

* Better way to handle the problem is getting your handlers out of main thread.
    ````java
    Executor executor = ...;  // obtain some Executor instance
        Task task = RemoteConfig.getInstance().fetch();
        // send the Executor as the first parameter
        task.addOnSuccessListener(executor, new OnSuccessListener() { ... });
    ````
>  If you do choose to use an Executor, be sure to manage them as shared singletons, or make sure their lifecycles are managed well so you don’t leak their threads.



## Task Listeners

````java
    Task addOnSuccessListener(OnCompleteListener listener) 
    Task addOnSuccessListener(Activity activity, OnSuccessListener listener) 
    Task addOnSuccessListener(Executor executor, OnSuccessListener listener) 
    
    Task addOnFailureListener(OnFailureListener listener)
    Task addOnFailureListener(Activity activity, OnFailureListener listener)
    Task addOnFailureListener(Executor executor, OnFailureListener listener)

    Task addOnCompleteListener(OnCompleteListener listener)
    Task addOnCompleteListener(Activity activity, OnCompleteListener listener)
    Task addOnCompleteListener(Executor executor, OnCompleteListener listener)    
````

````java
Task task = forestRef.getMetadata();
    task.addOnCompleteListener(new OnCompleteListener() {
        @Override
        public void onComplete (Task task) {
            if (task.isSuccessful()) {
                StorageMetadata meta = task.getResult();
                // Do something with metadata...
            } else {
                Exception e = task.getException();
                // Handle the failure...
            }
        }
    });
````

* With OnCompleteListener, you can have a single listener that handles both success and failure, and you find out which one by calling isSuccessful() on the Task object passed to the callback. 


## Resources

[Task API Series](https://firebase.googleblog.com/2016/09/become-a-firebase-taskmaster-part-1.html?utm_campaign=Firebase_culture_education_general_en_10-04-16&utm_source=Firebase&utm_medium=blog#heading=h.5n3odd424tqh)