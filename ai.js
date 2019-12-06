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

  if (allowedG && maneuver.g > allowedG) {
    // if maneuver G value is too high, try next maneuver with lower G
    return getManeuver(ship, side, index - 1, speed, allowedG);
  } else {
    // default to medium speed if maneuver doesn't contain specified speed
    var speed = maneuver.kineticEnergy[speed] ? speed : 'medium';

    return {'card': maneuver.card,
            'speed': speed,
            'kineticEnergy': maneuver.kineticEnergy[speed]};
  }
}

function getOverboostManeuver(ship, side, index, speed) {
  var overboosts = ship['overboost'][side];
  var overboost = overboosts[Math.min(index, overboosts.length - 1)];
  var maneuver = getManeuver(ship, side, index, speed, maxG - overboost.g);

  return {'card1': overboost.card,
          'card2': maneuver.card,
          'speed': maneuver.speed,
          'kineticEnergy': overboost.kineticEnergy + maneuver.kineticEnergy};
}
