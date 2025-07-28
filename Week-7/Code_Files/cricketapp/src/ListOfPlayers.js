import React from 'react';

function ListOfPlayers() {
  const players = [
    { name: 'Virat', score: 90 },
    { name: 'Rohit', score: 80 },
    { name: 'Rahul', score: 45 },
    { name: 'Shreyas', score: 60 },
    { name: 'Pant', score: 50 },
    { name: 'Jadeja', score: 95 },
    { name: 'Ashwin', score: 30 },
    { name: 'Bumrah', score: 55 },
    { name: 'Shami', score: 85 },
    { name: 'Ishan', score: 40 },
    { name: 'Gill', score: 100 }
  ];

  const filteredPlayers = players.filter(player => player.score >= 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with score &gt;= 70:</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListOfPlayers;