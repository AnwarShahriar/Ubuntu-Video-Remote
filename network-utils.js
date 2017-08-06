const os = require('os');

const getIP = () => {
    const ifaces = os.networkInterfaces();
    const ifaceKey = Object.keys(ifaces).find((key) => {
        return key.startsWith('wl');
    });

    return ifaces[ifaceKey].find((iface) => {
        return iface.family === 'IPv4';
    }).address;
}

module.exports = {
    ip: getIP
}