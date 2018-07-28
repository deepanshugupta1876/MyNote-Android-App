package deepanshu.example.com.mynote.main.note_details;

import com.squareup.otto.Subscribe;

import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.events.DetailNoteEvent;

/**
 * Created by Deepanshu on 19-07-2018.
 */

public class DetailNotePresenter extends BasePresenter<DetailNoteView,DetailNoteModel> {

    DetailNotePresenter(DetailNoteView mView, DetailNoteModel mModel) {
        super(mView, mModel);
    }

    @Subscribe
    public void setOnNoteAlreadyExist(DetailNoteEvent.OnNoteAlreadyExist onNoteAlreadyExist){

    }

    @Subscribe
    public void setOnSaveNoteToFirebaseClicked(DetailNoteEvent.OnSaveNoteToFirebaseClicked onSaveNoteToFirebaseClicked){

    }

    @Subscribe
    public void setOnSaveNoteToFirebaseSuccess(DetailNoteEvent.OnSaveNoteToFirebaseSuccess onSaveNoteToFirebaseSuccess){

    }

    @Subscribe
    public void setOnSaveNoteToFirebaseFailure(DetailNoteEvent.OnSaveNoteToFirebaseFailure onSaveNoteToFirebaseFailure){

    }
}
