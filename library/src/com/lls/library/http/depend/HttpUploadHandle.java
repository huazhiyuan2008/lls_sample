package com.lls.library.http.depend;


public interface HttpUploadHandle {

    public void onStart();

    public void onUpLoading(long uploaded, long total);

    public void onFailure(Exception e);

    public void onSuccess(String ret);
}
