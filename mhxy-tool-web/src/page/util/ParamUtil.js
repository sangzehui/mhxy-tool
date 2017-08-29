export function fixParam(param, pad) {
    if (pad == undefined) {
        pad = ' ';
    }
    for (let p in param) {
        if (param[p] == '')
            param[p] = pad;
    }
}