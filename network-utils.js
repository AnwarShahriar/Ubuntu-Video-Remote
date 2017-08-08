const os = require('os');

const getIP = () => {
    const ifaces = os.networkInterfaces();
    const ifaceKey = Object.keys(ifaces).find((key) => {
        return key.startsWith('wl');
    });

    const interface = ifaces[ifaceKey].find((iface) => {
        return iface.family === 'IPv4';
    });

    return interface.address;
}

module.exports = {
    ip: getIP
}