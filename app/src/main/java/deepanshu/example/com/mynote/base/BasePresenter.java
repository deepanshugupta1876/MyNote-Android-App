package deepanshu.example.com.mynote.base;

public abstract class BasePresenter <T extends BaseView, U extends BaseModel> {
    private T mView;
    private U mModel;

    public BasePresenter(T mView, U mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    public BasePresenter(T mView){
        this.mView = mView;
    }

    public T getmView(){
        return mView;
    }

    public U getmModel(){
        return mModel;
    }
}