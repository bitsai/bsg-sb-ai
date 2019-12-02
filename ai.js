function randNth(arr) {
  return arr[Math.floor(Math.random() * arr.length)];
}

function getVector(facing) {
  var facing = parseInt(facing, 10);

  if (facing == 12) {
    return {'side': randNth(['left', 'right']), 'index': 0};
  } else if (facing < 6) {
    return {'side': 'right', 'index': facing};
  } else if (facing == 6) {
    return {'side': randNth(['left', 'right']), 'index': 6};
  } else {
    return {'side': 'left', 'index': 12 - facing};
  }
}

function getManeuver(ship, side, index, speed) {
  var maneuver = ship['maneuver'][side][index];
  // default to medium speed if maneuver doesn't contain specified speed
  var speed = maneuver.kineticEnergy[speed] ? speed : 'medium';
  return {'cardNumber': maneuver.cardNumber,
          'kineticEnergy': maneuver.kineticEnergy[speed],
          'speed': speed};
}
