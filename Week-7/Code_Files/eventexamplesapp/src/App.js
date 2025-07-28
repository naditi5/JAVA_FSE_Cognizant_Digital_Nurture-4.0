import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      message: ''
    };
  }

  increment = () => {
    this.setState((prev) => ({ count: prev.count + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    console.log('Hello! This is a static message.');
    this.setState({ message: 'Hello! Count was incremented.' });
  };

  decrement = () => {
    this.setState((prev) => ({ count: prev.count - 1 }));
  };

  sayWelcome = (msg) => {
    this.setState({ message: msg });
  };

  handleClick = (event) => {
    console.log('Synthetic event triggered:', event);
    this.setState({ message: 'I was clicked' });
  };

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>React Events Demo</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayWelcome('Welcome to the app!')}>Say Welcome</button>

        <br /><br />
        <button onClick={this.handleClick}>OnPress</button>

        <h3>{this.state.message}</h3>

        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
