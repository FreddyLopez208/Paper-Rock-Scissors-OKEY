package es.ulpgc.eite.da.paper_rock_scissors.player2;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.paper_rock_scissors.game.AppMediator;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player1ToPlayer2State;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player2ToPlayer1State;
import es.ulpgc.eite.da.paper_rock_scissors.player1.Player1State;


/**
 * Created by Luis on marzo, 2023
 */

public class Player2Presenter implements Player2Contract.Presenter {

  public static String TAG = "Paper-Rock-Scissors.Player2Presenter";

  private WeakReference<Player2Contract.View> view;
  private Player2State state;
  private Player2Contract.Model model;
  private AppMediator mediator;

  public Player2Presenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = new Player2State();

    // TODO: add code if is necessary

    state.playerOption = model.getStoredData();

    Player1ToPlayer2State savedState = mediator.getPlayer1ToPlayer2ScreenState();
    if (savedState != null) {
      state.playerOption = savedState.playerOption;
    }
    view.get().onViewModelDataUpdated(state);

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: add code if is necessary
    state = new Player2State();
    state.playerOption = model.getStoredData();

    Player1ToPlayer2State savedState = mediator.getPlayer1ToPlayer2ScreenState();
    if (savedState != null) {
      state.playerOption = savedState.playerOption;
      mediator.setPlayer2ScreenState(state);
    }

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: add code if is necessary

    // update the view
    view.get().onViewModelDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: add code if is necessary

  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: add code if is necessary

  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: add code if is necessary

  }

  @Override
  public void onButtonClicked(String option) {
    Log.e(TAG, "onButtonClicked()");

    // TODO: add code if is necessary
    Player2ToPlayer1State newState = new Player2ToPlayer1State();

    newState.playerOption = option;

    mediator.setPlayer2ToPlayer1ScreenState(newState);

    view.get().navigateToPreviousScreen();

  }


  @Override
  public void injectView(WeakReference<Player2Contract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(Player2Contract.Model model) {
    this.model = model;
  }

}