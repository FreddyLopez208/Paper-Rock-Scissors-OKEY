package es.ulpgc.eite.da.paper_rock_scissors.player1;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.paper_rock_scissors.game.AppMediator;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player1ToPlayer2State;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player2ToPlayer1State;


/**
 * Created by Luis on marzo, 2023
 */

public class Player1Presenter implements Player1Contract.Presenter {

  public static String TAG = "Paper-Rock-Scissors.Player1Presenter";

  private WeakReference<Player1Contract.View> view;
  private Player1State state;
  private Player1Contract.Model model;
  private AppMediator mediator;

  public Player1Presenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = new Player1State();

    // TODO: add code if is necessary
    state.playerOption = model.getStoredData();

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: add code if is necessary
    state = new Player1State();

    state.playerOption = model.getStoredData();

    Player2ToPlayer1State savedState = mediator.getPlayer2ToPlayer1ScreenState();
    if (savedState != null) {
      state.playerOption = savedState.playerOption;
      mediator.setPlayer1ScreenState(state);
    }

    view.get().onViewModelDataUpdated(state);

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: add code if is necessary
    Player2ToPlayer1State savedState = mediator.getPlayer2ToPlayer1ScreenState();

    if (savedState != null) {
      state.playerOption = savedState.playerOption;
    }

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

    Player1ToPlayer2State newState = new Player1ToPlayer2State();

    newState.playerOption = option;

    mediator.setPlayer1ToPlayer2ScreenState(newState);

    view.get().navigateToNextScreen();

  }


  @Override
  public void injectView(WeakReference<Player1Contract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(Player1Contract.Model model) {
    this.model = model;
  }

}