import { BaseService } from './base-service';

export class DeckService extends BaseService {
  basePath = "deck/"
  currentDeckKey: string;

  deckActive() {
    return !!this.currentDeckKey;
  }

  new() {
    delete this.currentDeckKey;
    return super.doGet(this.basePath + "new").then(
      (id) => {
        this.currentDeckKey = id
        return id;
      }
    );

  }

  shuffle() {
    if (!this.currentDeckKey) {
      return Promise.reject("No deck started");
    }

    return super.doGet(this.basePath + "shuffle/" + this.currentDeckKey);
  }

  dealOneCard() {
    if (!this.currentDeckKey) {
      return Promise.reject("No deck started");
    }

    return super.doGet(this.basePath + "deal-one-card/" + this.currentDeckKey).then(
      (card) => {
        if (!card) {
          delete this.currentDeckKey;
        };
        return card;
      }
    );
  }

}
