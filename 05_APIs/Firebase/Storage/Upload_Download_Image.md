# Firebase Storage Image Upload - Download

## Uploading

```java
StorageReference storage = FirebaseStorage.getInstance().getReference();
StorageReference ref = storage.child("user_photos/" + currentUser.getUid() );
ref.putFile(profile_photo_path).addOnCompleteListener( task->{
          if( task.isSuccessful() ){
            // success
          }else{
            // error
          }
      });
```

### Example

```java
  StorageReference storage = FirebaseStorage.getInstance().getReference();
  if(profile_photo_path != null){
      ProgressDialog progressDialog = new ProgressDialog(this);
      progressDialog.setTitle("Uploading");
      progressDialog.show();

      StorageReference ref = storage.child("user_photos/" + currentUser.getUid() );
      ref.putFile(profile_photo_path).addOnCompleteListener( task->{
          if( task.isSuccessful() ){
              progressDialog.dismiss();
              Toast.makeText(this, "Uploaded",Toast.LENGTH_LONG).show();
          }else{
              progressDialog.dismiss();
              Snackbar.make( profile_photo , task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
          }
      }).addOnProgressListener( taskSnapshot -> {
          double progress = ( 100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
          progressDialog.setMessage("Uploaded " + (int)progress + "%");
      });

  }
```

## Download



### Example

```java
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        // Profile Photo
        try{
            File local_photo_file = File.createTempFile("images","jpg");
            StorageReference photoRef = storageReference.child("user_photos/" + currentUser.getUid());
            photoRef.getFile(local_photo_file).addOnCompleteListener( task -> {
                if(task.isSuccessful()) {
                    updateProfileImage(local_photo_file);
                }
                else
                    Snackbar.make( profile_photo , task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
            }).addOnProgressListener( taskSnapshot -> {

            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void updateProfileImage(File local_photo_file) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(local_photo_file));
            profile_photo.setImageBitmap(bitmap);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
```

### Using Picasso API
* Caching Property comes with picasso api

```java
StorageReference photoRef = storageReference.child("user_photos/" + currentUser.getUid());
        photoRef.getDownloadUrl().addOnCompleteListener( task ->{
            if( task.isSuccessful())
                Picasso.get().load(task.getResult()).into(profile_photo);
            else
                Snackbar.make( profile_photo , task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
        });
```
