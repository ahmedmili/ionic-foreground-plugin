import { registerPlugin } from '@capacitor/core';

import type { ForegroundPluginPlugin } from './definitions';

const ForegroundPlugin = registerPlugin<ForegroundPluginPlugin>('ForegroundPlugin', {
  web: () => import('./web').then((m) => new m.ForegroundPluginWeb()),
});

export * from './definitions';
export { ForegroundPlugin };
