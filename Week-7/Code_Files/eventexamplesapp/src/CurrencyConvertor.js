import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const euroValue = parseFloat(this.state.rupees) / 90; 
    this.setState({ euro: euroValue.toFixed(2) });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Amount in ₹ INR:
            <input
              type="number"
              value={this.state.rupees}
              onChange={this.handleChange}
              required
            />
          </label>
          <button type="submit">Convert</button>
        </form>
        <p>Converted Amount in Euro: <strong>{this.state.euro}</strong></p>
      </div>
    );
  }
}

export default CurrencyConvertor;
