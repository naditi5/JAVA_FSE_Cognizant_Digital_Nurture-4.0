
import React from 'react';

function IndianPlayers() {
  const OddTeam = ['Virat', 'Rohit', 'Pant', 'Jadeja', 'Shami'];
  const EvenTeam = ['Rahul', 'Gill', 'Ashwin', 'Bumrah', 'Ishan', 'Surya'];

  
  const [odd1, odd2, ...restOdd] = OddTeam;
  const [even1, even2, ...restEven] = EvenTeam;

  const T20Players = ['Kohli', 'Rohit', 'Bumrah'];
  const RanjiPlayers = ['Ruturaj', 'Jaiswal', 'Siraj'];

  const allPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        {restOdd.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players:</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        {restEven.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>All Combined Players (T20 + Ranji):</h2>
      <ul>
        {allPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
}

export default IndianPlayers;