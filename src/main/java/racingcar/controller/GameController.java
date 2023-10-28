package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.model.Cars;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;

    public GameController(GameView gameView, InputHandler inputHandler) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
    }

    public void startGame() {
        String carNames = gameView.inputCarNames();
        List<String> nameList = inputHandler.convertNamesToNameList(carNames);

        String inputAttempts = gameView.inputAttempts();
        int attempts = inputHandler.convertAttemptsToInt(inputAttempts);

        Cars cars = Cars.of(nameList);

        gameView.showRaceResult();
        for (int i = 0; i < attempts; i++) {
            cars.move();

            List<String> carStatusList = cars.getCarStatusList();
            gameView.showCarStatus(carStatusList);
        }

        List<String> winnerList = cars.getWinnerList();
        gameView.showWinnerList(winnerList);
    }
}
