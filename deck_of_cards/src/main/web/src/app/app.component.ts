import { Component } from '@angular/core';

import { DeckService } from './provider/deck-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  deckStarted: boolean;
  executing: boolean;
  hasCard: boolean;
  currentCard: any;

  constructor(private deckService: DeckService) {
  }

  startDeck() {
    this.executing = true;
    this.deckService.new().then(
      () => this.executing = false,
      this.showError
    );
    this.hasCard = true;
    this.deckStarted = true;
  }

  getCard() {
    this.currentCard = null;
    this.executing = true;
    this.deckService.dealOneCard().then(
      (card) => {
        this.executing = false;
        this.currentCard = card;
        this.hasCard = !!card;
      },
      this.showError
    );
  }

  shuffle() {
    this.executing = true;
    this.deckService.shuffle().then(
      () => this.executing = false,
      this.showError
    );
  }

  newDeck() {
    let createNew = true;
    if (this.deckService.deckActive()) {
        createNew = confirm("Deck still has card. Get a new?");
    }

    if (createNew) {
      this.executing = true;
      this.deckService.new().then(
        () => {
          this.executing = false
          this.hasCard = true
        },
        this.showError
      );
    }
  }

  showError() {
    this.executing = false;
    alert('Ops! Something went wrong');
  }
}
