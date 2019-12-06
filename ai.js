var maxG = 4;

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

function getManeuver(ship, side, index, speed, allowedG) {
  var maneuvers = ship['maneuver'][side];
  var maneuver = maneuvers[Math.min(index, maneuvers.length - 1)];

  if (allowedG && maneuver.g < allowedG) {
    // if maneuver G value is too low, try next maneuver with higher G
    return getManeuver(ship, side, index + 1, speed, allowedG);
  } else {
    // default to medium speed if maneuver doesn't contain specified speed
    var speed = maneuver.kineticEnergy[speed] ? speed : 'medium';

    return {'cardNumber': maneuver.cardNumber,
            'speed': speed,
            'kineticEnergy': maneuver.kineticEnergy[speed]};
  }
}

function getOverboostManeuver(ship, side, index, speed) {
  var overboosts = ship['overboost'][side];
  var overboost = overboosts[Math.min(index, overboosts.length - 1)];
  var maneuver = getManeuver(ship, side, 0, speed, maxG - overboost.g);

  return {'cardNumber1': overboost.cardNumber,
          'cardNumber2': maneuver.cardNumber,
          'speed': maneuver.speed,
          'kineticEnergy': overboost.kineticEnergy + maneuver.kineticEnergy};
}
